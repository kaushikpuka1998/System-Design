class OnlineReaderSystem

    @Library
    @OnlineManager
    @Display
    @Active_users
    
    def initialize
        @Library = Library.new
        @Display = Display.new
        @Active_users = Hash.new
    end

    def getLibrary
        @Library
    end

    def getDisplay
        @Display
    end

    def get_active_users
        @Active_users
    end

    def set_active_user(user_id)
      if @Active_users[user_id].nil? || @Active_users[user_id] == 0
        @Active_users[user_id] = 1
        puts "UID:#{user_id}, You have Successfully Logged IN "
      else
        puts "UID:#{user_id} you already LoggedIn "
      end
    end

    def set_active_user_to_inactive(user_id)
      if @Active_users[user_id].nil? || @Active_users[user_id] == 0

        puts "UID:#{user_id}, You have already Logged Out"
      else
        @Active_users[user_id] = 0
        puts "UID:#{user_id} you are currently offline"
      end
    end

    def add_books(book)

        @Library.add_books_to_the_list(book)
    end

    def adding_booking_to_user(user_id,book_id)
      if !get_active_users[user_id].nil? && get_active_users[user_id]>0
        @Library.allocate_book_to_user(user_id,book_id)
      else
        puts "Sorry either You are currently Offline or not registered!!!"
      end

    end
end


class Display

end

class User
    
    @id
    @name

    def initialize(id,name)
        @id =id
        @name = name
    end

    def get_user_name
        @name
    end

    attr_accessor :id
end

class Library


    @list_of_books
    def initialize
        @list_of_books = Hash.new
    end

    def add_books_to_the_list(book)

        if @list_of_books[book.book_id].nil?
            @list_of_books[book.book_id] = book

            puts "=====#{book.get_book_name} Added in the Library===="
        else
            puts "Same Book ID Found"
        end    
    end

    def allocate_book_to_user(user_id,book_id)
        if !@list_of_books[book_id].nil?
            if @list_of_books[book_id].get_alloc_user>0
                puts "Sorry!!! #{@list_of_books[book_id].get_book_name} allocated to UserID: #{@list_of_books[book_id].get_alloc_user}"
            else
                @list_of_books[book_id].set_alloc_user(user_id)
                puts "Booking ID: #{book_id} is Allocated to User ID: #{user_id} "
            end
        else
            puts "Sorry!!! The book ID: #{book_id} is not present in the Library"
        end
    end

    def books_list
        @list_of_books
    end

end

class Book
    
    @book_id
    @book_name
    @avaiable
    @aloc_user
   def initialize(id,name,avaiable)
        @book_id = id
        @book_name = name
        @avaiable = avaiable
        @aloc_user = -15
   end

   def get_book_name
        @book_name
   end

   def get_availability
        @avaiable
   end
   
   def get_alloc_user
        @aloc_user
   end

   def set_alloc_user(user_id)
       @aloc_user = user_id 
   end

   attr_accessor :book_id
end

online_reader_system = OnlineReaderSystem.new

algo_book1 = Book.new(1,"Algo_book",1)

algo_book2 = Book.new(2,"Introduction to Java",1)

kaushik = User.new(134,"Kaushik Ghosh")
sanglap = User.new(135,"sanglap Dey")


# online_reader_system.get

#puts (algo_book1.book_id)

online_reader_system.getLibrary.add_books_to_the_list(algo_book1)

online_reader_system.getLibrary.add_books_to_the_list(algo_book2)

online_reader_system.set_active_user(134);
online_reader_system.set_active_user(135);
puts online_reader_system.adding_booking_to_user(134,1);
puts online_reader_system.adding_booking_to_user(135,2);


online_reader_system.set_active_user_to_inactive(135);
puts ":::All Active Users:::"
puts online_reader_system.get_active_users

# value = {1 => "PAPC"}

# value.map{ |f,s|
#     @Library[f] = s
# }



