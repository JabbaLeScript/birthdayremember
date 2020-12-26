<template>
  <div class="hello">
    <Header />
    <div class="container mrgnbtm">
      <div class="row">
        <div class="col-md-8">
          <CreatePerson @createPerson="personCreate($event)" />
        </div>
        <div class="col-md-4">
          <DisplayBoard :number-of-persons="numberOfPersons" @getAllPersons="getAllPersons()" />
        </div>
      </div>
    </div>
    <div class="row mrgnbtm">
      <Persons v-if="persons.length > 0" :persons="persons" />
    </div>
  </div>
</template>

<script>
import Header from "@/components/Header";
import CreatePerson from "@/components/CreatePerson";
import DisplayBoard from "@/components/DisplayBoard";
//import Persons from "@/components/Persons";
import {getAllPersons, createPerson} from "@/services/UserService";
import Persons from "@/components/Persons";

export default {
  name: "Dashboard",
  components: {
    Persons,
    Header,
    CreatePerson,
    DisplayBoard,
  },
  data() {
    return {
      persons: [],
      numberOfPersons: 0

    }
  },
  methods: {
    getAllPersons(){
      getAllPersons().then(response => {
        console.log(response)
        this.persons = response
        this.numberOfPersons = this.persons.length
          })
      },
    personCreate(data) {
      console.log('data:::', data)
      data.id = this.numberOfPersons + 1
      createPerson(data).then(response => {
        console.log(response);
        this.getAllPersons();
      });
    }
  },
  mounted() {
    this.getAllPersons();
  }
}
</script>

<style scoped>

</style>