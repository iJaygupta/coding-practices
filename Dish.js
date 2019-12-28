let ingred = ["fibrefood1", "fibrefood2", "fibrefood3", "fibrefood4", "fibrefood5", "fibrefood6", "fibrefood7", "fatfood7"]
let dish = [];
for (let i = 0; i < ingred.length; i = i + 3) {
    dish.push(ingred[0])
    dish.push(ingred[1])
    ingred.splice(0, 2)
    for (let j = 0; j < ingred.length; j++) {
        try {
            if (dish[i].substring(0, 3) == dish[i + 1].substring(0, 3) && dish[i].substring(0, 3) != ingred[j].substring(0, 3)) {
                dish.push(ingred[j])
                ingred.splice(j, 1)
                break
            }
            if (dish[i].substring(0, 3) == ingred[j].substring(0, 3) && dish[i].substring(0, 3) != dish[i + 1].substring(0, 3)) {
                dish.push(ingred[j])
                ingred.splice(j, 1)
                break
            }
            if (dish[i + 1].substring(0, 3) == ingred[j].substring(0, 3) && dish[i].substring(0, 3) != dish[i + 1].substring(0, 3)) {
                dish.push(ingred[j])
                ingred.splice(j, 1)
                break
            }
        }
        catch (TypeError) {
            break
        }

    }
}
if (dish.length > 0 && dish.length % 3 != 2) {
    console.log("Can't prepare any dish")
}
else {
    for (let i = 0; i < dish.length; i++) {
        process.stdout.write(dish[i] + ":")
        if (i > 0 && i % 3 == 2) {
            console.log()
        }
    }
}


