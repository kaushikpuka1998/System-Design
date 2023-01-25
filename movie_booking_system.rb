class AllPerson
  @allPersons

  def initialize
    if @allPersons.nil?
      @allPersons = Array.new
    else
      @allPersons
    end
  end
  def register(person)
    @allPersons<<person
  end

  def find_by_id(id)
    for i in 0..@allPersons.size-1
      if @allPersons[i].id == id
        return @allPersons[i]
      end
    end
    return nil
  end

  def getalluser
    @allPersons
  end
end
class CinemaHall
  attr_accessor :id, :name, :address, :Screens

  @id
  @name
  @address
  @Screens

  def initialize(id,name,address,screens)
    @id = id
    @name= name
    @address = address
    @Screens = screens
  end
end


module Person
  attr_accessor :id, :name, :address, :email, :phone

  @id
  @name
  @address
  @email
  @phone
  @allPersons
  @active


  def initialize(id,name,address,email,phone)
    @id = id
    @name = name
    @address = address
    @email = email
    @phone = phone
    @active = 1
  end
end

class Guest
  include Person

  def register

  end

end

class Admin
  include Person

  def block_user(id)
    alluser = AllPerson.new
    selecteduser = alluser.find_by_id(id)
    selecteduser.active = 0
  end

end

class Customer
  include Person

end

admin = Admin.new(2,"kg","Bangalore","kg@gmail.com","9775288755")

kaushik = Guest.new(1,"kaushik","Jalpaiguri","kaushik@gmail.com","8159924565")
allperson = AllPerson.new

allperson.register(kaushik)

puts allperson.getalluser.inspect
puts allperson.find_by_id(1).nil? ? "Nil" : allperson.find_by_id(1).name