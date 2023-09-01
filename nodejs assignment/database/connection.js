const Sequelize=require("sequelize");

const sequelize= new Sequelize("training", 'root', 'root', {host: 'localhost', dialect: "mysql", operatorAliases: false});

module.exports=sequelize;
global.sequelize=sequelize;