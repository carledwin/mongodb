/*current database*/
db

/*remove current database */
db.dropDatabase()

/*remove collection*/
db.collectionToDrop.drop()
db.students.drop()

/*use or create database*/
use newDatabase2
use databasetoDrop
use mydb
use mySchool

/*create collection*/
db.createCollection("myCollection")
db.moreOneCollection.insert({"letter":"a"})
db.createColClection("collectionToDrop")
db.createCollection("students")

/*show all databases*/
show dbs

/*show collectionscof the current database*/
show collections

/*create collection, document and insert*/
db.mycollection.insert({"name":"Carl Edwin"})
db.new__collection.insert({"u_user":"User"})
db.user.insert({"product":"Product 1"})
db.user.insert({"product":"Product 2"})
db.students.insert([
				{
				  "StudentNo":"1",
				  "FirstName":"Carl",
				  "LastName":"Nascimento",
				  "Age":"35"
				  },
				  {
				  "StudentNo":"2",
				  "FirstName":"Maria",
				  "LastName":"Alcantara",
				  "Age":"53"
				  },
				  {
				  "StudentNo":"3",
				  "FirstName":"Amaury",
				  "LastName":"Nobrega",
				  "Age":"18"
				  },
				  {
				  "StudentNo":"4",
				  "FirstName":"Fernandino",
				  "LastName":"Bessa",
				  "Age":"15"
				  }
			]
			)


/*select specific document*/
db.mycollection.find({"name":"Carl Edwin"})

/*select all*/
db.user.find({})
db.students.find()
db.students.find({}).pretty()
db.students.findOne()
db.students.find({"StudentNo":"2"})

/* find document major Age */
db.students.find(
{
  "Age": {$gt : "18"}
})


/* find document equal or minor Age */
db.students.find(
{
"Age":{$lte : "18"}
})

/* find document not equal Age */
db.students.find(
{
  "Age": {$ne : "18"}
})

/* find document equal Age */
db.students.find(
{
  "Age": {$eq : "53"}
})
