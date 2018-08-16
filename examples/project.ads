# Flowchart Project LifeCylce V1

# options
chart.name = "Project LifeCylce V1"

# roles
customer.name = "Customer"
firstContact.name = "First Contact Employee"
management.name = "Management"
projectLeader.name = "Project Leader"
projectTeam.name = "Project Team"

# flow diagram
chart.state = "Initiation"
customer.start("Sends request")
firstContact.do("New message in slack #request")

if management.do("Accept Request?"):
    chart.state = "Planning"
    management.do("define project leader")
    projectLeader.do("create porject in pms")
    projectLeader.do("create slack channel #project and invite team")
    projectLeader.do("create folder structure on drive")
    do while !management.do("is concept ok?"):
        projectTeam.do("create concept")
    do while !management.do("Project approved?"):
        projectLeader.do("plan resources")
    chart.state = "Implementation"
    projectLeader.do("change pms status")
    do while !management.do("is project finished"):
        projectTeam.do("work on project")
        projectLeader.do("create finished documentation")
        projectLeader.do("report to management")
        projectLeader.do("report to customer")
    chart.state = "Closing"
    projectLeader.do("create & send invoice")
    projectLeader.do("create short recap of project")
    projectLeader.do("cleanup and archive project")
else:
    firstContact.out("Message to customer")

customer.end()