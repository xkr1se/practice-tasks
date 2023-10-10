function persistence(num = 0, repeat = 1) {
    if(num < 10 && repeat === 1) return 0

    const multiplier = [...num.toString()]
                                        .map(charNumber => Number.parseInt(charNumber))
                                        .reduce((num1, num2) => num1 * num2)

    return multiplier < 10 ? repeat : persistence(multiplier, ++repeat)
}