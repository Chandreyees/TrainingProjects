'use strict';

module.exports = {
  async up (queryInterface, Sequelize) {
   queryInterface.createTable("student",{
    id:{
      type: Sequelize.INTEGER(20),
      allowNull: false,
      primaryKey: true,
  },
  dateOfBirth:{
      type: Sequelize.DATE,
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
  },
  createdAt: Sequelize.DATE,
  updatedAt: Sequelize.DATE,
   })
  },

  async down (queryInterface, Sequelize) {
    queryInterface.dropTable("student");
  }
};
