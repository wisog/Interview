let cadena = "(79,34)Holaafklndfoi(10asldkfj)(98,902843)lnkjasdlnkfjas(34,56)Bingopingolingo";

let regex = /\((\d+,\d+)\)((?:(?!\(\d+,\d+\)).)*)/g; // 2 groups

let match; // locate each match in regex

while ((match = regex.exec(cadena)) !== null) { // As long as there are matches in the chain
    console.log("(" + match[1] + ")" + match[2]); // group the matches
}
