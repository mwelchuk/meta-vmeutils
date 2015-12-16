SUMMARY = "VME utilites for controlling vme-user"
SECTION = "utilities"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://vme_master.c;beginline=5;endline=8;md5=3c689b529fbe7fb846bed880c797fa1e"

SRC_URI =  "file://vme_master.c \
	    file://vme_user.h"

S = "${WORKDIR}"

do_compile() {
	${CC} -o vme_master vme_master.c
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 vme_master ${D}${bindir}
}
