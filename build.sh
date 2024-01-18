#!/bin/bash
set -e

cd ..

pushd Messaging-utilities
./build.sh
popd

# Build the services
pushd Token-Service
./build.sh
popd

pushd Account-service
./build.sh
popd

pushd Payment-service
./build.sh
popd

pushd Reporting-service
./build.sh
popd

pushd Facade
./build.sh
popd
