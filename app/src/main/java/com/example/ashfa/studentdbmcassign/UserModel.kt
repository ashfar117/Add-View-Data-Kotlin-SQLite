package com.example.ashfa.studentdbmcassign


class UserModel{

    var studentId : String = ""
    var studentName : String = ""
    var studentActivity : String = ""
    var studentCost : String = ""


    constructor(studentId:String, studentName:String, studentActivity:String, studentCost:String){
        this.studentId=studentId
        this.studentName=studentName
        this.studentActivity=studentActivity
        this.studentCost=studentCost
    }

    constructor()

}