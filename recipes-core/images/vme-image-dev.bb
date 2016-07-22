
require recipes-core/images/core-image-minimal.bb

DESCRIPTION = "A small image for VME development work."

IMAGE_INSTALL += " \
	dropbear \
	kernel-modules \
	kmod \
	vme-utils \
	vme-test-mod \
	"

