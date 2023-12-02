#!/bin/bash
echo "显示硬盘使用情况："
df -h
echo "内存使用情况："
free -h
echo "CPU使用情况："
mpstat
