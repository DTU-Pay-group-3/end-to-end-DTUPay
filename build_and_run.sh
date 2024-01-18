#!/bin/bash
set -e

./build.sh


./deploy.sh
sleep 5
./test.sh


# Cleanup the build images
docker image prune -f


