const useProductFormat = () => {


    const getInfo = (info) => {
        const infoArr = info.split(" ")

        const format = infoArr.shift()
        const size = infoArr.splice(0, 3).join("")
        const finish = infoArr.join(" ")

        return [ format, size, finish ]
    }


    const getPrice = (price, multiplier=1) => {

        const euro = Intl.NumberFormat('en-DE', {
            style: 'currency',
            currency: 'EUR',
            useGrouping: false,
        })

        return euro.format(price * multiplier)
    }

    
    return [getInfo, getPrice]
}

export default useProductFormat