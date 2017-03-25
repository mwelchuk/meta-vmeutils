SUMMARY = "Linux kernel"
SECTION = "kernel"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

# Override SRC_URI in a copy of this recipe to point at a different source
# tree if you do not want to build from Linus' tree.
SRC_URI = "git://git.collabora.com/git/user/martyn/linux.git;branch=vme_test"
#SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/gregkh/char-misc.git;branch=char-misc-next"

SRC_URI += "file://defconfig"

LINUX_VERSION ?= "4.10"
LINUX_VERSION_EXTENSION_append = "-driverdev"

# Modify SRCREV to a different commit hash in a copy of this recipe to
# build a different release of the Linux kernel.
# tag: v4.2 64291f7db5bd8150a74ad2036f1037e6a0428df2
#SRCREV_machine="64291f7db5bd8150a74ad2036f1037e6a0428df2"
SRCREV_qemux86-64="${AUTOREV}"

PV = "${LINUX_VERSION}+git${SRCPV}"

# Override COMPATIBLE_MACHINE to include your machine in a copy of this recipe
# file. Leaving it empty here ensures an early explicit build failure.
COMPATIBLE_MACHINE = "qemux86-64"
