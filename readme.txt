use user_service
db.createUser({ user: "root", pwd: "pass@word1", roles: [{ role: "dbOwner", db: "user_service" }] })

c:\>mongodump --db user_service --out c:\user_service.json


{
  "userName" : "admin@admin",
  "password" : "admin",
  "firstName" : "Admin",
  "lastName" : "Admin",
  "contactNumber" : 9434580584,
  "role" : "ADMIN" 
}

{
  "userName" : "user01@163.com",
  "password" : "pass@word1",
  "firstName" : "User_01",
  "lastName" : "Li",
  "contactNumber" : 9434580584,
  "role" : "USER"
}
{
  "userName" : "user02@163.com",
  "password" : "pass@word1",
  "firstName" : "User_02",
  "lastName" : "Wang",
  "contactNumber" : 9433764150,
  "role" : "USER"
}
{
  "userName" : "user03@163.com",
  "password" : "pass@word1",
  "firstName" : "User_03",
  "lastName" : "Zhang",
  "contactNumber" : 9434580584,
  "role" : "USER"
}

{
  "userName" : "mentor01@163.com",
  "password" : "pass@word1",
  "firstName" : "Mentor_01",
  "lastName" : "Guo",
  "contactNumber" : 9434580584,
  "role" : "MENTOR",  
  "linkedinUrl" : "mentor01@163.com",
  "yearsOfExperience" : 12
}
{
  "userName" : "mentor02@163.com",
  "password" : "pass@word1",
  "firstName" : "Mentor_02",
  "lastName" : "Sun",
  "contactNumber" : 9434580584,
  "role" : "MENTOR",  
  "linkedinUrl" : "mentor02@163.com",
  "yearsOfExperience" : 10
}