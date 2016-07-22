SUMMARY = "VME utilites for controlling vme-user"
SECTION = "utilities"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://vme_master.c;beginline=6;endline=9;md5=3c689b529fbe7fb846bed880c797fa1e"

inherit autotools

SRC_URI =  "git://git.collabora.com/git/vme/vme-utils.git"

S = "${WORKDIR}/git"

SRCREV = "${AUTOREV}"

