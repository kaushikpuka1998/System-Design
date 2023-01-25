class AllPerson
  @allPersons

  def initialize
    @allPersons = Array.new
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

  def initialize(id,name,address,email,phone)
    @id = id
    @name = name
    @address = address
    @email = email
    @phone = phone
  end
end

class Guest
  include Person

  def register

  end

end

class Admin
  include Person

end

class Customer
  include Person

end

kaushik = Guest.new(1,"kaushik","Jalpaiguri","kaushik@gmail.com","8159924565")
allperson = AllPerson.new

allperson.register(kaushik)

puts allperson.getalluser.inspect
puts allperson.find_by_id(1).name