SUMMARY = "VME test module for the Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=12f884d2ae1ff87c09e5b7ccc2c4ca7e"

inherit module

SRC_URI = "git://gitlab.collabora.com/vme/vme-test-mod.git;protocol=https"

S = "${WORKDIR}/git"

SRCREV="${AUTOREV}"
