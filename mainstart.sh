#!/bin/bash

#Software Dependencies
read -p "Updating all your dependencies? [y/N] " answerA
if [ $answerA = "y" ] ; then
./maindependencies.sh >> logs/dependencieslog.txt
fi
#Git checking out
read -p "Commit and push to local/remote repository? [y/N]" answerB
if [ $answerB = "y" ] ; then
read -p "Add commit message " commitmessage
./checkoutlocal.sh "$commitmessage" >> logs/commitlog.txt
fi
#Junit Test Netbeans
read -p "Start unit Test [y/N] " answerC
if [ $answerC = "y" ] ; then
./junitnetbeans.sh >> logs/junitnetbeanslog.txt
fi
