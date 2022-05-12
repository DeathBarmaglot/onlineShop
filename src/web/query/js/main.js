$(document).ready(()=>{
    $('#searchForm').on('submit', (e) => {
        let searchText = $('#searchText').val();
        getMovies(searchText);
        e.preventDefault();
    })
});

const getMovies = (searchText) => {
    
    axios.get('http://www.omdbapi.com/' + '?s=' + searchText + '&apikey=c0bf5d80')
    .then((res) => {parseMovies(res)})
    .catch((e)=>{console.log(e)})
}

const parseMovies = (res) => {

    let movies = res.data.Search;
    let output = '';
    $.each(movies, (index, movie)=> {
        console.log(movie);
        output+=`
        <div class="col-md-3">
            <div class="wall text-center">
            <img src="${movie.Poster}">
                <h5>${movie.Title}</h5>
                <a onclick="movieSelected('${movie.imdbID}')" class="btn btn-primary" href="#">Details</a>
            </div>
        </div>
        `;
    })

    $('#movies').html(output);
}

