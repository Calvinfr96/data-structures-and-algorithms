class Student {
    static all = []; //static property. You can't use const to declare a variable in the class body.

    constructor(firstName, lastName, year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = year;
        this.tardies = 0;
    }

    save() {
        Student.all.push(this)
    }

    static getStudents() {
        return Student.all;
    } //static method

    fullName() {
        return `Your full name is ${this.firstName} ${this.lastName}`;
    } //Note: Instance methods in JavaScript are declared without using the function keyword.

    markLate() {
        this.tardies++;
        if(this.tardies > 2) {
            return 'YOU HAVE BEEN EXPELLED'
        }
        return `You have now been late ${this.tardies} time(s)`;
    }
}

class Point {
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }

    static distance(a,b) {
        const dx = a.x - b.x;//You can use const to declare a variable in the method body.
        const dy = a.y - b.y;
        return Math.hypot(dx,dy);
    }
}