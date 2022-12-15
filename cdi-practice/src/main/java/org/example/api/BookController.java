package org.example.api;

import org.example.ejb.BookEJB;
import org.example.entity.Book;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("/book")
@Stateless
public class BookController {
    @Inject
    private BookEJB bookEJB;

    @Context
    private UriInfo uriInfo;

    @GET
    public Response getBooks() {
        List<Book> books = bookEJB.findBooks();

        return Response.ok(books).build();
    }

    @POST
    public Response createBook(Book book) {
        if (book == null) {
            throw new BadRequestException();
        }
        bookEJB.createBook(book);
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId()).build();
        return Response.created(bookUri).build();
    }

    @GET
    @Path("{id}")
    public Response getBook(@PathParam("id") String id) {
        Book book = bookEJB.findBookBYId(id);

        if (book == null) {
            throw new NotFoundException();
        }

        return Response.ok(book).build();
    }

    @PUT
    @Path("{id}")
    public Response updateBook(@PathParam("id") String id, Book book) {
        if (book == null) {
            throw new BadRequestException();
        }

        bookEJB.updateBook(book);

        return Response.ok().build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteBook(@PathParam("id") String id) {
        if (id == null) {
            throw new BadRequestException();
        }
        Book book = bookEJB.findBookBYId(id);

        bookEJB.deleteBook(book);

        return Response.noContent().build();
    }
}
