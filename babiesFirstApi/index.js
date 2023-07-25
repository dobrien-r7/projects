


const userAction = async () => {
    const response = await fetch('http://example.com/movies.json');
    const myJson = await response.json(); //extract JSON from the http response
    // do something with myJson
  }
