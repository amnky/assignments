use ownerpets;
SELECT * FROM ownerpets.pets;

#all owner details along with their city names-- 
select o.owner_id, o.name, o.phone, c.city
from owners o
join cities c on o.postal_code = c.postal_code;

#all pets and their owner's names-- 
select p.pet_name, o.name 
from pets p
join owners_pet op on p.pet_id = op.pet_id
join owners o on op.owner_id = o.owner_id;

#all pets of a specific breed-- 
select p.pet_name, b.breed_name
from pets p
join breeds b on p.breed_id = b.breed_id
where b.breed_name = 'yellow lab';

#number of pets each owner has-- 
select o.name, count(op.pet_id) as pet_count
from owners o
join owners_pet op on o.owner_id = op.owner_id
group by o.name;

#all cities and the number of pet owners in each city-- 
select c.city, count(o.owner_id) as owner_count
from cities c
left join owners o on c.postal_code = o.postal_code
group by c.city;

#all owners who have more than one pet-- 
select o.name
from owners o
join owners_pet op on o.owner_id = op.owner_id
group by o.name
having count(op.pet_id) > 1;

#get owner name whose pet name is michael-- 
select o.name, p.pet_name, b.breed_name from pets p
join breeds b on p.breed_id = b.breed_id and p.pet_name = 'michael'
join owners_pet op on p.pet_id = op.pet_id
join owners o on op.owner_id = o.owner_id;

#find the name of pets whose owners are based in new york-- 
select p.pet_name, c.city from cities c
join owners o on o.postal_code = c.postal_code and c.city = 'new york'
join owners_pet op on op.owner_id = o.owner_id
join pets p on p.pet_id = op.pet_id;