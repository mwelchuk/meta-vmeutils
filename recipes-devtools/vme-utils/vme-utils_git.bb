SUMMARY = "VME utilites for controlling vme-user"
SECTION = "utilities"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://vme_master.c;beginline=6;endline=9;md5=3c689b529fbe7fb846bed880c797fa1e"

inherit autotools

SRC_URI = "git://gitlab.collabora.com/vme/vme-utils.git;protocol=https"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

PV = "git${SRCPV}"

