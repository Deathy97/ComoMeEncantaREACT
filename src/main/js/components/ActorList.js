import React from "react";
import ActorItem from "./ActorItem"
import ActorCount from "./ActorCount"
import Update from "./Update"

export default class ActorList extends React.Component {

	constructor(props) {
		super(props)
		this.state = { actores: [] }
	}

  render() {
		if (this.state.actores.length == 0) {	
			fetch('/api/v1/actor/list/')
			.then((response) => {
				return response.json();
			})			
			.then((actor) => {
        		this.setState({ actores: actor })
      		})
			
		}

		if (this.state.actores.length > 0) {
		
			var actorItems = [];
			this.state.actores.forEach(
				(actor) => {
					actorItems.push(<ActorItem actor={actor} />)
				}
			)
		
		return (
				<div>
					{actorItems}
					<ActorCount  count={actorItems.length}/>
				</div>
			)
			
		
		} else {
			return <p className="text-center">Loading users...</p>
		}  
  }
}