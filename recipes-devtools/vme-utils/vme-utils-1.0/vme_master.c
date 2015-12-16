/* Simple VME User module test.
 *
 * Copyright 2015 Martyn Welch <martyn@welchs.me.uk>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, version 2 of 
 * the License.
 *
 * This test opens the first VME master window, configures it as follows:
 * - A24 Address space
 * - Address: 0x30000
 * - Size: 0x10000
 * - Access Mode: User/Data
 * - Mode: 16-bit transfers
 *
 * It then attempts to read and print out the first 512 bytes of data found
 * at this address.
 */
#define _XOPEN_SOURCE 500
#include <stdio.h>
#include <stdlib.h>
#include <sys/ioctl.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include "vme_user.h"
int main(int argc, char *argv[])
{
        int fd;
        int i;
        int retval;
        unsigned char data[512];

        struct vme_master master;

        printf("Simple VME User Module Test\n");

        fd = open("/dev/bus/vme/m0", O_RDONLY);
        if (fd == -1) {
                perror("ERROR: Opening window device file");
                return 1;
        }

        master.enable = 1;
        master.vme_addr = 0x30000;
        master.size = 0x10000;
        master.aspace = 2; // VME_A24
        master.cycle = 0x2000 | 0x8000; // user/data access
        master.dwidth = 2; // 16 bit word access

        retval = ioctl(fd, VME_SET_MASTER, &master);
        if (retval != 0) {
                printf("retval=%d\n", retval);
                perror("ERROR: Failed to configure window");
                return 1;
        }

        /*
         * Reading first 512 bytes
         */
        for (i=0; i<512; i++) {
                data[i] = 0;
        }

        retval = pread(fd, data, 512, 0);
        if (retval < 512) {
                printf("WARNING: Only read %d bytes", retval);
        }

        for(i=0; i<retval; i++) {
                if (i % 8 == 0) {
                        printf("\n""%4.4x: ", i);
                }
                printf("%2.2x ", data[i]);
        }
        printf("\n");

        close(fd);

        return 0;
}
