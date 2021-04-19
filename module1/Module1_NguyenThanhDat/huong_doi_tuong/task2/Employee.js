var Employee = function () {
    this.getName = function () {
        return this.name;
    };
    this.getBirth = function () {
        return this.birth;
    };
    this.getPhone = function () {
        return this.phone;
    }
    this.getEmail = function () {
        return this.email;
    }
    this.getIdCard = function () {
        return this.idCard;

    }
    this.getLevel = function () {
        return this.level;
    }
    this.getLocation = function () {
        return this.location;
    }
    this.getSalary = function () {
        if (this.getLocation() === "Manager") {
            this.salary = 500;
        } else if (this.getLocation() === "Sale") {
            this.salary = 300;
        } else if (this.getLocation() === "Makerting") {
            this.salary = 200;
        }
        return this.salary;
    }
    this.setName = function (name) {
        this.name = name;

    }
    this.setBirth = function (birth) {
        this.birth = birth;

    }
    this.setPhone = function (phone) {
        this.phone = phone;

    }
    this.setEmail = function (email) {
        this.email = email;

    }
    this.setIdcard = function (idCard) {
        this.idCard = idCard;

    }
    this.setLevel = function (level) {
        this.level = level;

    }
    this.setName = function (name) {
        this.name = name;

    }
    this.setLocation = function (location) {
        this.location = location;

    }
}
