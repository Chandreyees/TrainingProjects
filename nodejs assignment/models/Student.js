const Sequelize = require("sequelize");

module.exports = sequelize.define("Student", {

    id:{
        type: Sequelize.INTEGER(20),
        allowNull: false,
        primaryKey: true,
    },
    dateOfBirth:{
        type: Sequelize.STRING,
        allowNull: false,
    },
    name:{
        type: Sequelize.STRING(100),
        allowNull: false,
        validate:{
            notEmpty: true
        }
    },
    score:{
        type: Sequelize.INTEGER(10),
        allowNull: false,
        validate:{
            notEmpty: true,
        }
    }
});