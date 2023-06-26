import AdminWrapper from '@/components/AdminWrapper'
import axios from 'axios'
import Link from 'next/link'
import { useRouter } from 'next/router'
import { useEffect, useState } from 'react'

export default function ModifyAboutUs() {
	const [aboutUsText, setAboutUsText] = useState('')

	const sendRequest = () => {
		axios.post('/api/text/aboutUsText', aboutUsText).then((d) => {
			if (d.status == 201) {
				window.open('/admin/', '_self')
			}
		})
	}

	useEffect(() => {
		axios.get('/api/text/aboutUsText').then((res) => {
			setAboutUsText(
				decodeURIComponent(res.data.text.replace(/\+/g, ' ')).slice(0, -1)
			)
		})
	}, [])

	return (
		<AdminWrapper>
			<textarea
				style={{ width: '100%' }}
				value={aboutUsText}
				onChange={(e) => setAboutUsText(e.target.value)}
			></textarea>
			<button
				className="btn btn-primary mt-4"
				onClick={() => {
					sendRequest()
				}}
			>
				Save
			</button>
		</AdminWrapper>
	)
}
