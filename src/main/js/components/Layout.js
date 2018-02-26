import React from "react"
import { addActor} from "../actions/actorActions"
import ActorForm from "./ActorForm"
import ActorList from "./ActorList"

export default class Layout extends React.Component {

  render() {
   
    return (
      <div class="text-center">
	      <ActorForm />	
	      <ActorList />	
      </div>
    )
  }
}