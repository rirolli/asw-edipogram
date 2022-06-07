#!/bin/bash

echo Starting Consul in a Docker Container 

docker run -d --hostname localhost --name consul --publish 8500:8500 consul
