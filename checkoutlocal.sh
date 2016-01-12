#!/bin/bash
cd /home/donovan/integration/PlanetisJava-Connection
git fetch
git checkout connection
git add -A
git commit -a "Changes"
git status
git push origin connection
git status
cd /home/donovan/integration
