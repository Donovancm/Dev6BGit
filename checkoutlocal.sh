#!/bin/bash
if [$# -gt 1 ] || [ $# -lt 1 ] ; then
#
exit
else
echo "Checkout and commit" 
git checkout master
git add *
git commit -am "$1"
git status
git push 
git log >> commitlog.txt
fi
