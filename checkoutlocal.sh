#!/bin/bash
if [$# -gt 1 ] || [ $# -lt 1 ] ; then
echo "Usage: ./checkoutlocal.sh [Commit message]"
exit
else
echo "Checkout and commit" 
git checkout master
git add .
git commit -m "$1"
git status
git push origin master
git log
fi
