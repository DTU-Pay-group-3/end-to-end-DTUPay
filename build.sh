#!/bin/bash
set -e

CMD cd ..

pushd messaging-utilities-3.4
./build.sh
popd

# Build the services
pushd token
./build.sh
popd

pushd account
./build.sh
popd

pushd payment
./build.sh
popd

pushd report
./build.sh
popd

pushd facade
./build.sh
popd