#!/bin/bash
search=$(grep -n "完成" /data/a)
echo "$search" > "searchResult"
echo $search
