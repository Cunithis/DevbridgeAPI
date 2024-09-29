# DevbridgeAPI
Spring Boot Rest Api for Sourcery Academy

Methods:

Create a book:
POST /api/books

Example JSON:
{
        "title": "Harry Potter and the Philosopher's Stone",
        "author": "J.K Rowling",
        "publicationYear": 1997,
        "genre": "Fantasy"
}

Get all books:
GET /api/books

Filter by title,author,year or rating:
GET /api/books?title={title}
GET /api/books?author={author}
GET /api/books?publicationYear={publicationYear}
GET /api/books?rating={rating}

Get book by id:
GET /api/books/{id}

Set a books' rating:
GET /api/books/rating?id={id}&rating={rating}

For database I used H2 database.
