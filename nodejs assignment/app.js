const express=require("express");
const bodyParser=require("body-parser");
const d = require('date-and-time');
const port=3000;
const app=express();
const path=require("path");

const mysql=require("mysql2");
//const db=require('./models');
const db=require('./database/connection');
const Student=require('./models/Student');
const sequelize = require("./database/connection");
const { result } = require("lodash");
const s=[];

app.use(bodyParser.urlencoded({extended:true}));
app.use(express.static(path.join(__dirname, "public")));
// app.use(express.static("public"));
app.set('view engine', 'ejs');
app.set('views','views');



app.get("/", function(req,res){
   res.render("home");
});

app.get("/teacher1",async function(req,res){
    const data= await Student.findAll();
    console.log(data);
   res.render("teacher1", {dataList: data});
});

app.get("/home", function(req,res){
    res.render("home");
})

app.get("/teacher2", function(req,res){
    res.render("teacher2");
});

app.post("/teacher2", async function(req,res){
    const roll=req.body.roll;
    const name=req.body.name;
    const date=req.body.dob;
    console.log("The DATE IS : ",date);
    const score=req.body.score;
   
    await Student.create({
        id: roll,
        dateOfBirth: date,
        name: name,
        score: score,
    });

    res.redirect("/teacher1");
});

app.get("/teacher1/:id", async function(req,res){
    const id=req.params.id;
    try{
        const data=await Student.findByPk(id);
        res.render("edit",{data});
    }catch(err){
        console.log(err);
    }

});

app.post("/edit", async function(req,res){
    const id=req.body.id;
    const name=req.body.name;
    const date=req.body.dob;
    console.log("The DATE IS : ",date);
    const score=req.body.score;
    const data=await Student.update(
        {
        dateOfBirth: date,
        name: name,
        score: score,
    },
    {
        where: {

            id: id,
  
          },
    }
    );
    res.redirect("/teacher1");
});

app.get("/teacher2/:id", async function(req,res){
    const id=req.params.id;
    await Student.destroy({where: {id: id}});
    res.redirect("/teacher1");
});

//Student :

app.get("/student1", function(req,res){
    
    res.render("student1");
});


app.post("/find", async function(req,res){
    const id=req.body.id;
    const name=req.body.name;
   
    try{
        const data=await Student.findAll({where: {id:id,name:name}});
        console.log(data);
        


        res.render("student2", {data: data});
    }catch(err){
        console.log("Data entered are wrong!");
    }
})



sequelize.sync().then((result)=>{
    app.listen(port, function(){
        console.log("Server started!!");
    }); 
}).catch((err)=>console.log(err));
