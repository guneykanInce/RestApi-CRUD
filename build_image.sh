#!/usr/bin/env bash

set -e

IMAGE_NAME="app/useraccounts"

docker build --tag "$IMAGE_NAME" .
