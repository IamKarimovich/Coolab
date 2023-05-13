import axios from 'axios'

export default function EventTest() {
	const sendRequest = () => {
		var data = new FormData()
		data.append(
			'name',
			(document.getElementById('name') as HTMLInputElement).value
		)
		data.append(
			'description',
			(document.getElementById('description') as HTMLInputElement).value
		)
		data.append('image', (document.getElementById('image') as any).files[0])
		data.append(
			'date',
			(document.getElementById('date') as HTMLInputElement).value
		)
		data.append(
			'link',
			(document.getElementById('link') as HTMLInputElement).value
		)
		data.append(
			'eventType',
			(document.getElementById('eventType') as HTMLInputElement).value
		)
		data.append(
			'status',
			(document.getElementById('status') as HTMLInputElement).value
		)
		axios({
            method:'post',
            url:'/api/events/',
            data:data,
            headers:{"Content-Type": "multipart/form-data"}
        }).then((d)=>{
			console.log(d)
		})
	}

	return (
		<>
			<input type="text" name="name" id="name" /> <br />
			<input type="text" name="description" id="description" /> <br />
			<input type="file" name="image" id="image" /> <br />
			<input type="text" name="date" id="date" /> <br />
			<input type="text" name="link" id="link" /> <br />
			<input type="text" name="eventType" id="eventType" /> <br />
			<input type="text" name="status" id="status" /> <br />
			<button onClick={()=>{sendRequest()}}>Submit</button>
		</>
	)
}
