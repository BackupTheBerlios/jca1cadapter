#
#Use this script to fresh your project copy from CVS
#of www.berlios.de using anonymous access
#

if [ ! -x "./build.sh" ] ; then
    echo
    echo "No build.sh script found on current path."
    echo "Please, run this script on the same path as build.sh"
    echo
    exit
fi

BUILD_CMD="./build.sh "
CHECKOUT_CMD="checkout"
CHECKOUTALL_CMD="checkoutall"

if [ "$1" = "all" ] ; then
    $BUILD_CMD $CHECKOUTALL_CMD
else
    $BUILD_CMD $CHECKOUT_CMD
fi

exit
