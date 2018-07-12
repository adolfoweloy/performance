import psutil

cpus = psutil.cpu_times_percent(1, True)
print "user\tsystem\tidle"

for cpu in cpus:
    print "%.2f\t%.2f\t%.2f" % (cpu.user, cpu.system, cpu.idle)
