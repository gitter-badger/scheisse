#!/usr/bin/python
__author__ = 'dedda'

import sys

n = len(sys.argv)
i = 0

if n <= 1:
    exit()

decode = False
input = None
output = None

while i < n:
    i += 1
    arg = sys.argv[i]
    if arg == "--decode":
        decode = True
        continue
    if arg == "--input":
        i += 1
        input = sys.argv[i]
        continue
    if arg == "--output":
        i += 1
        output = sys.argv[i]
        continue

if input == None:
    print "specify input!"
    exit()
if output == None:
    print "specify output!"
    exit()

if decode:
    print "decoding from " + input + " to " + output
else:
    print "encoding from " + input + " to " + output
