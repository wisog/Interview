String.prototype.reverse = function () {
    var x = this.length;
    var cadena = "";
    while (x >= 0) {
        cadena = cadena + this.charAt(x);
        x--;
    }
    return cadena;
};