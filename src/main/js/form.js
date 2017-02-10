import React from 'react';
import ReactDOM from 'react-dom';
import Client from './client';
import Groups from './groups';

export default React.createClass({
	getInitialState: function() {
		return {
			pages: [],
			data: []
		}
	},
	
	//Default On Change Function
	handleChange(event){
		console.log("ChangeHandler target ID: "+event.target.id);
		console.log("ChangeHandler target value : "+event.target.value);
		
		var stateCopy = Object.assign({}, this.state);
		var key = event.target.id;
		stateCopy.data[key] = event.target.value;

		this.setState(stateCopy);
		console.log("After Updating State: ",this.state.data)
	},
	
	componentDidMount() {
		Client({method: 'GET', path: '/api/pages'}).done(response => {
			this.setState({
				pages:response.entity._embedded.pages
			});
			console.log("Fetching from: /api/pages")
			console.log("Pages Data : ", response);
		});
	},
	
	render() {	
		var _that = this;
		return <div>
				{
					this.state.pages.map(function(item,i){		//Simulating multiple pages
						return(
							<div key={i}>
								<div className="well" id={item.name}>
									Page name: {item.label}
								</div>	
								<Groups groupLink = {item._links.formGroups.href} onChange={_that.handleChange}/>
							</div>
						)
					})
				}
		</div>
	}
})