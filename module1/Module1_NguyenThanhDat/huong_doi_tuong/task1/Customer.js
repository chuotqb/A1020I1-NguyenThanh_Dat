// let Customer = function () {
//     this.setName = function (name) {
//         this.name = name;
//     };
//     this.getName = function () {
//         return this.name;
//
//     }
//     this.setIdCard = function (idCard) {
//         this.idCard = idCard;
//     };
//     this.getIdCard = function () {
//         return this.idCard;
//
//     }
//     this.setBirth = function (birth) {
//         this.birth = birth;
//     };
//     this.getBirth = function () {
//         return this.birth;
//
//     }
//     this.setEmail = function (email) {
//         this.email = email;
//     };
//     this.getEmail = function () {
//         return this.email;
//
//     }
//     this.setAdress = function (adress) {
//         this.adress = adress;
//     };
//     this.getAdress = function () {
//         return this.adress;
//
//     }
//     this.setTypeCus = function (typecus) {
//         this.typecus = typecus;
//     };
//     this.getTypeCus = function () {
//         return this.typecus;
//
//     }
//     this.setDiscount = function (discount) {
//         this.discount = discount;
//     };
//     this.getDiscount = function () {
//         return this.discount;
//
//     }
//     this.setNofa = function (nofa) {
//         this.nofa = nofa;
//     };
//     this.getNofa = function () {
//         return this.nofa;
//
//     }
//     this.setTyperoom  = function (typeRoom) {
//         this.typeRoom = typeRoom;
//     };
//     this.getTyperoom = function () {
//         return this.typeRoom;
//
//     }
//     this.setrenDay = function (renDay) {
//         this.renDay = renDay;
//     };
//     this.getrenDay = function () {
//         return this.renDay;
//
//     }
//     this.settypeService = function (typeService) {
//         this.typeService = typeService;
//     };
//     this.gettypeService = function () {
//         return this.typeService;
//
//     }
//     this.totalPays=function () {
//         let money=0;
//         if (this.gettypeService()==="Villa"){
//             money=500;
//         }else if (this.gettypeService()==="House"){
//             money=300;
//         }else if (this.gettypeService()==="Room"){
//             money=200;
//         }
//         return this.getrenDay()*money*(1-this.getDiscount()/100);
//
//     }
//
// }
class Customer {
    constructor(name, idCard, birth, email, adress, typeCus, discount, nofa, typeRoom, renDay, typeService) {
        this.name = name;
        this.idCard = idCard;
        this.birth = birth;
        this.email = email;
        this.adress = adress;
        this.typeCus = typeCus;
        this.discount = discount;
        this.nofa = nofa;
        this.typeRoom = typeRoom;
        this.renDay = renDay;
        this.typeService = typeService;
    }

    getName() {
        return this.name;
    }

    getIdCard() {
        return this.idCard;
    }

    getBirth() {
        return this.birth;
    }

    getEmail() {
        return this.email;
    }

    getAdress() {
        return this.adress;

    }
    getTypeCus(){
        return this.typeCus;
    }
    getDiscount(){
        return this.discount;
    }
    getNofa(){
        return this.nofa;
    }
    getTypeRoom(){
        return this.typeRoom;
    }
    getRenDay(){
        return this.renDay;
    }
}