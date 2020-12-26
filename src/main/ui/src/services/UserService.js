export async function getAllPersons(){
    const response = await fetch('birthdayreminder/api/persons');
    return await response.json();
}

export async function createPerson(data){
    const response = await fetch('birthdayreminder/api/persons', {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(data)
    })
    return await response.json();
}