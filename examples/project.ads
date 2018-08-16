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
else
	firstContact.out("Message to customer")

chart.state = "Closing"
customer.end()