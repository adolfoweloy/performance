import psutil
import sys

interval = 1
if len(sys.argv) == 2:
    interval = float(sys.argv[1])

while True:
    cpus = psutil.cpu_times_percent(interval, True)
    print "user\tsystem\tidle"
    for cpu in cpus:
        print "%.2f\t%.2f\t%.2f" % (cpu.user, cpu.system, cpu.idle)
    print "---"
