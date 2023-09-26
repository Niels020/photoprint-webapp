// https://dev.to/shaedrizwan/building-custom-hooks-in-react-to-fetch-data-4ig6

import { useEffect, useState  } from 'react'

const useFetch = (url) => {

    const [data,setData] = useState(null)
    const [error,setError] = useState(null)

    useEffect(() => {
        (
            async function(){
                try{
                    const response = await fetch(url)
                    const data = await response.json()
                    setData(data)
                }catch(err){
                    setError(err)
                }
            }
        )()
    }, [url])

    return [ data, error ]

}

export default useFetch